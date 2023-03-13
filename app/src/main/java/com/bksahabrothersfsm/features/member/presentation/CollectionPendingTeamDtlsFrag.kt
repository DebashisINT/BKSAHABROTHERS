package com.bksahabrothersfsm.features.member.presentation

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bksahabrothersfsm.CustomStatic
import com.bksahabrothersfsm.R
import com.bksahabrothersfsm.app.AppDatabase
import com.bksahabrothersfsm.app.NetworkConstant
import com.bksahabrothersfsm.app.Pref
import com.bksahabrothersfsm.app.domain.AddShopDBModelEntity
import com.bksahabrothersfsm.app.domain.CollectionDetailsEntity
import com.bksahabrothersfsm.app.domain.OrderDetailsListEntity
import com.bksahabrothersfsm.app.utils.AppUtils
import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.base.presentation.BaseActivity
import com.bksahabrothersfsm.base.presentation.BaseFragment
import com.bksahabrothersfsm.features.addshop.api.AddShopRepositoryProvider
import com.bksahabrothersfsm.features.addshop.model.AddShopRequestData
import com.bksahabrothersfsm.features.addshop.model.AddShopResponse
import com.bksahabrothersfsm.features.billing.presentation.AddBillingFragment
import com.bksahabrothersfsm.features.dashboard.presentation.DashboardActivity
import com.bksahabrothersfsm.features.location.LocationWizard
import com.bksahabrothersfsm.features.newcollectionreport.*
import com.bksahabrothersfsm.features.shopdetail.presentation.AddCollectionWithOrderDialog
import com.bksahabrothersfsm.features.shopdetail.presentation.api.addcollection.AddCollectionRepoProvider
import com.bksahabrothersfsm.features.shopdetail.presentation.model.addcollection.AddCollectionInputParamsModel
import com.bksahabrothersfsm.features.viewAllOrder.api.addorder.AddOrderRepoProvider
import com.bksahabrothersfsm.features.viewAllOrder.model.AddOrderInputParamsModel
import com.bksahabrothersfsm.features.viewAllOrder.model.AddOrderInputProductList

import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*
import kotlin.collections.ArrayList


class CollectionPendingTeamDtlsFrag : BaseFragment(), View.OnClickListener {
    private lateinit var mContext: Context
    private lateinit var rv_CollectiondtlsList: RecyclerView
    private lateinit var adapter: CollectionPendingDtlsAdapter
    private var collectionDialog: AddCollectionWithOrderDialog?= null
    private lateinit var progress_wheel: ProgressWheel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        var mobj: PendingCollData? = null
        fun getInstance(objects: Any): CollectionPendingTeamDtlsFrag {
            val collectionPendingDtlsFrag = CollectionPendingTeamDtlsFrag()
            if (objects != null) {
                if (objects is PendingCollData)
                    this.mobj = objects
            }
            return collectionPendingDtlsFrag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_collection_pending_dtls_team, container, false)
        initView(view)

        return view
    }

    private fun initView(view: View) {
        rv_CollectiondtlsList = view.findViewById(R.id.rv_frag_coll_pending_dtle_team_list)
        progress_wheel = view.findViewById(R.id.progress_wheel)
        progress_wheel.stopSpinning()

        getData()
    }

    private fun getData(){
        var objList: ArrayList<PendingCollDtlsData> = ArrayList()
        var orderList = AppDatabase.getDBInstance()?.orderDtlsTeamDao()?.getListAccordingToShopId(mobj!!.shop_id!!)
        var objPendingList: ArrayList<PendingCollDtlsData> = ArrayList()
        if (orderList != null && orderList.size > 0) {
            for (i in 0..orderList.size - 1) {
                var objPending: PendingCollDtlsData = PendingCollDtlsData("0", "0", "0", "0", "0", "0",
                    "0", "0", ArrayList<CollectionList>(), "","")
                objPending.shop_id = mobj!!.shop_id
                objPending.shop_name = mobj!!.shopName
                objPending.order_id = orderList.get(i).order_id.toString()
                objPending.order_date = orderList.get(i).only_date.toString()
                objPending.order_amt = orderList.get(i).amount.toString()

                var bDtlList = AppDatabase.getDBInstance()!!.billDtlsTeamDao().getDataOrderIdWise(objPending.order_id.toString())
                if(bDtlList!= null && bDtlList.size>0){
                    objPending.bill_id=bDtlList.get(0).bill_id
                }


                var invList = AppDatabase.getDBInstance()!!.billDtlsTeamDao().getDataOrderIdWise(orderList.get(i).order_id.toString()!!)
                if (invList != null && invList.size > 0) {
                    objPending.invoice_id = invList.get(0).invoice_no
                    objPending.invoice_date = invList.get(0).invoice_date
                    objPending.invoice_amt = invList.get(0).invoice_amount
                }

                var totalCollAmt=0.0
                var totalPendingAmt=objPending.order_amt

                var collList = AppDatabase.getDBInstance()?.collDtlsTeamDao()?.getListOrderWise(orderList.get(i).order_id!!)
                if (collList != null && collList.size > 0) {
                    for (k in 0..collList.size - 1) {
                        var collectionObj: CollectionList = CollectionList("0", "0", "0")
                        collectionObj.coll_id = collList.get(k).collection_id.toString()
                        collectionObj.coll_amt = collList.get(k).collection.toString()
                        collectionObj.coll_date = collList.get(k).date.toString()
                        objPending.coll_list.add(collectionObj)
                        try{
                            totalCollAmt=totalCollAmt+collList.get(k).collection!!.toDouble()
                        }catch (ex:Exception){
                            totalCollAmt=totalCollAmt+0
                        }
                    }
                }

                totalPendingAmt=(objPending.order_amt.toDouble()-totalCollAmt.toDouble()).toString()

                var totalInvAmt ="0"
                if(Pref.IsCollectionEntryConsiderOrderOrInvoice){
                    var ob=AppDatabase.getDBInstance()!!.billDtlsTeamDao().getInvoiceSumAmt(objPending.order_id.toString())
                    if(ob!=null)
                        totalInvAmt=(totalInvAmt.toDouble()+ob.toDouble()).toString()
                    else{
                        totalInvAmt="0"
                    }

                    totalPendingAmt=(totalInvAmt.toDouble()-totalCollAmt.toDouble()).toString()
                    if(totalPendingAmt.contains("-")){
                        totalPendingAmt="0"
                    }
                }


                objPending.pendingAmt=totalPendingAmt
                if(totalPendingAmt.equals("0.0") || totalPendingAmt.equals("0")){

                }else{
                    objPendingList.add(objPending)
                }

            }
        }

        if (objPendingList.size > 0)
            initAdapter(objPendingList)
    }

    private fun initAdapter(list: ArrayList<PendingCollDtlsData>) {
        CustomStatic.IsCollectionViewFromTeam = true
        adapter = CollectionPendingDtlsAdapter(mContext, list, object : PendingCollDtlsListner {
            override fun getInfoDtlsOnLick(obj: PendingCollDtlsData) {
//                openCollDialog(obj)
            }
        })

        rv_CollectiondtlsList.adapter = adapter
    }

    override fun onClick(p0: View?) {

    }
}