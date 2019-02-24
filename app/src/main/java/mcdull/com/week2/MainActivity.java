package mcdull.com.week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.Unbinder;
import recycler.coverflow.RecyclerCoverFlow;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "HomeFragMent";
    @BindView(R.id.banner)
    RecyclerCoverFlow banner;
    Unbinder unbinder;
    @BindView(R.id.rxxp)
    RecyclerView rxxp;
    @BindView(R.id.miss)
    RecyclerView miss;
    @BindView(R.id.pzsh)
    RecyclerView pzsh;
    @BindView(R.id.btn_rxxp)
    ImageView btnRxxp;
    @BindView(R.id.btn_miss)
    ImageView btnMiss;
    @BindView(R.id.btn_pzsh)
    ImageView btnPzsh;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.img_choose)
    ImageView imgChoose;
    private HomePresenter presenter;
    private List<BannerBean.ResultBean> bannerList;
    private BannerAdapter bannerAdapter;
    private List<HomeBean.ResultBean.RxxpBean.CommodityListBean> rxxpList;
    private List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> missList;
    private List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> pzshList;
    private RxxpAdapter rxxpAdapter;
    private MissAdapter missAdapter;
    private PzshAdapter pzshAdapter;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new HomePresenter();
        presenter.attach(this);
        initData();
        presenter.getBanner();
        presenter.getHome();
        imgChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ProductCategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
