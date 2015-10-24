package diamond_client_test.diamond_client_test;

import java.util.concurrent.Executor;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        DiamondManager manager = new DefaultDiamondManager("cnq", "cnq-dubbo-test-dev",
                new ManagerListener() {//填写你服务端后台保存过的group和dataId
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("changed config: " + configInfo);
                }
                public Executor getExecutor() {
                return null;
                }
            });
            //设置diamond-server服务的端口
            manager.getDiamondConfigure().setPort(8080);

            String availableConfigureInfomation = manager.getAvailableConfigureInfomation(5000);
            System.out.println("start config: " + availableConfigureInfomation);
            
    }
}
