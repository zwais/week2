package mcdull.com.week2.presenter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import mcdull.com.week2.ICallBack;
import mcdull.com.week2.model.ShowProductModel;
import mcdull.com.week2.view.ShowProductView;

public class ShowPrpductPresenter {
    private ShowProductView sv;
    private ShowProductModel model;
    public void attach( ShowProductView sv){
       this.sv=sv;
       model=new ShowProductModel();
    }

    public void getData(int commodityId){
        Type type=new TypeToken<ShowProductBean>(){}.getType();
        model.getData(commodityId, new ICallBack() {
            @Override
            public void successful(Object o) {
                ShowProductBean data= (ShowProductBean) o;
                if (data!=null & "0000".equals(data.getStatus())){
                    sv.successful(data);
                }
            }

            @Override
            public void failed(Exception e) {
                sv.failed(e);
            }
        },type);

    }

    public void detach(){
        if (sv!=null){
            sv=null;
        }
    }
}
