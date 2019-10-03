package com.elife.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 */
public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public final static String APP_ID = "2016101200669614";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public final static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCN0zhPJRDLedVkXiGIJvTkyoMXYJ+N68M0km6QQlgEF5aHJtAc0Yj0r5XRr9uWsJ4TroCt2jG62B8Z8MSFcp5d83DiLxGhWS/ROsddGPKy1wwGFPk6L4GWluxP8aV2PF4kxnR/0IGtA/Bz7MdNjVkl1hAAM5FbkiX452Cr1Ydq1PnDiSEgPj+rVQdb6C5cIFWJgk6naYahFyyhRCrdlVwtTKIE8KQce8F419qAk/rp2XaYihKfMRzc0gO03as+ftcPiRcHEAHH4/BtlAd8BzAbR/MoUlh0rBX3VqOjljTeLwT4/ge4b5CdiwQDdxe+OCCZiZhTp4x12zpQLNggnQNFAgMBAAECggEAD+Ac5X8Yqi4xHNMMndj+gL3KfstqENDbQP9DMRK8F3kseGR310H9OqaM9rPguLV8fGeEL/HEr02R7a1t0iJKZ+ngMPFj39PD7n/N4TXxtOMtjWC7pS+8KccrHKfIBbwsLaGpWMVWPq+6Mr/Gb3/rArk7gUpEcyOg7IO55oI4blTN3jyyTuCppszw3kAoZjZ8IWhG3UGk6PP1oj9C5jTrMYrL/RVtXNJ9VFILIyTFViWP4oLVy0HpSa5/eaXza1URQAQ0gm/22/B1UZjW6EsxrQ0iD0Y1hg6w8v23JtGZ+4/6yTaiHmDWyTppeG3ImBNf1PCHeQ3/SgJ4H1FkbPuxAQKBgQDTKKS4UEM+Prcn99tHDsT1zNaPiMl+2u5GiPeFPHT+7ics57bu0ogXaJ/5Ma2zUZC6kFhRbaVooIuvvE2xc+lQlda7cZht2YlQ+yufNNxL2dN+OO8Z2Lcrv6KvZ+bPSb/rTjYU7ecaVvKvX5qloM7lyWOyvROOBYV5DEmsN+WHuQKBgQCr8ViGjxvt5qnjd458b7virAvFoGwHZ32JeQBA79vrHo2srGQOi4/s06j2n5VNooMmZMjGkHlmOKco+TXn4S4ScSGW0MZCRuAF1L2Jdbc++k7MuGGuaHEuRtMlfPwkEtR/PmnAXY2WB3Xl/TjQ1CE08ITwsyRQPFkH1UhhSZXF7QKBgQCkoiazkdirukghQG1V3J0SLBAJvxOi9V0b34Rk/DsX3GTs7QjC8aCr56X6q5ILooed/hbt/fgeODZQ4RcOSRpa+0h9wtaepyIZ4osjSRqNhRsRaaB6XW6LDJHyAqeBbLXW55bhAI/UCICU3Yx8oIFPxZIW9LY/X+yt8Terr7Uk+QKBgAM9ehCXE8yo4xyxPRMlO+IqodIoksCU962mhRW0L22/1qWhXgVUJfMtjeqP2U1sOZJ4pbvwLwl5GdVQ1O44tRiN3zcrWgEXutMBTk0P1dMu/lsnQlf6Cd/4X7Q+JbY8UJrRP0brvGZOX69k1TRCOxn3SloK1i1Y5cibAVEsBNGFAoGAdvOphHPfjvj41yJ5whY6TvAvsgbvMmIy9RHfn23GfDBVzvbNi+Jc3B4jD6BhCWo7aricJAJzua5BSQyi7wk+zg/b8Ui5iBPD39uuBJySxnM0CdFzxLkZDrJHirprw5br2NbNpCIDSRZHjgdiyaE3a9i24rx4euweDnOiEtkeVXc=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public final static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw/NXxp26YbHS93q66qLP4iuYcilrxYaeYBnKCeNmr8Evm9DwlhbKiHoHDEDH5v5zPpAPKWf7+a5b/5GsRe9cFypBZt+7hRgCuVNsXJjgOU1fsprUS4+6s0L+H1/mZKPEB4Nqzt1UYcb/A6ddMeO9+KXdaj4UHVL2YzAKxokLjYzTyei3byvAlx99xqQf2U9eKuuvVI82/g7CcRNMPbDrMDz/NNbH6PD+P9N2cgEfOgivAnjLdx8H5TKqOSqU1CWAcYwYxtXSL2kgLLbOZo8NzvF5bW9TcqzyehWdWTTo+g/7kaMZxsBlzGk0e1Iqxk2XpG4ERWnskvdSRE89S54FiQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public final static String NOTIFY_URL = "";//这里根据你项目中的controller进行配置

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public final static String RETURN_URL = "http://localhost:8080/alipay/returnUrl";//这里根据你项目中的controller进行配置

    // 签名方式
    public final static String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public final static String CHARSET = "utf-8";

    // 支付宝网关
    /* public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";//项目正式使用后使用 */
    public final static String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";//使用沙箱环境时使用

    // 数据格式
    public final static String FORMAT = "JSON";

    // 支付宝网关日志信息
    public final static String log_path = "C:\\";

    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


    /**
     * 写日志，方便记录（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
