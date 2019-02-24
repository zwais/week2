package mcdull.com.week2.popupwindow;

import soexample.umeng.com.beiwei.bean.CommodityByCategoryBean;
import soexample.umeng.com.beiwei.bean.PopBean;

public interface PopView {
    void getFirst( PopBean data );

    void getCommodityByCategory( CommodityByCategoryBean data );

    void getSecond( PopBean data );

    void failed( Exception e );
}
