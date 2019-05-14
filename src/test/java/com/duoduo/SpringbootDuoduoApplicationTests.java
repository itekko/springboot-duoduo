package com.duoduo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.duoduo.common.config.BaiduProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootDuoduoApplicationTests {

    @Autowired
    private BaiduProperties baiduProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试签名
     */
    @Test
    public void sign(){
        Map<String,Object> param = new HashMap<>();
        param.put("grant_type",baiduProperties.getToken().get("grantType"));
        param.put("client_id",baiduProperties.getOcr().get("apiKey"));
        param.put("client_secret",baiduProperties.getOcr().get("secretKey"));

        String result = HttpUtil.post(baiduProperties.getToken().get("url").toString(),param);
        /**
         * {
         * 	refresh_token: "25.2935508fbfd17442f8d3d72cfd2fe3a3.315360000.1872471147.282335-16177245",
         * 	expires_in: 2592000,
         * 	session_key: "9mzdAvRUJUd5C/l9GRq6VIzLDJhgO4FpbwBc/hySP0Us+WqEoL1QYIXQHJprHQSjKjPll38ZPKw0zDpCsi9nEm9J5g8FWw==",
         * 	access_token: "24.9609093b1b9755e16a6c5be3374e5824.2592000.1559703147.282335-16177245",
         * 	scope: "public vis-ocr_ocr brain_ocr_scope brain_ocr_general brain_ocr_general_basic vis-ocr_business_license brain_ocr_webimage brain_all_scope brain_ocr_idcard brain_ocr_driving_license brain_ocr_vehicle_license vis-ocr_plate_number brain_solution brain_ocr_plate_number brain_ocr_accurate brain_ocr_accurate_basic brain_ocr_receipt brain_ocr_business_license brain_solution_iocr brain_ocr_handwriting brain_ocr_passport brain_ocr_vat_invoice brain_numbers brain_ocr_train_ticket brain_ocr_taxi_receipt vis-ocr_车辆vin码识别 vis-ocr_定额发票识别 brain_ocr_vin brain_ocr_quota_invoice wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian ApsMisTest_Test权限 vis-classify_flower lpq_开放 cop_helloScope ApsMis_fangdi_permission smartapp_snsapi_base iop_autocar oauth_tp_app smartapp_smart_game_openapi oauth_sessionkey smartapp_swanid_verify smartapp_opensource_openapi smartapp_opensource_recapi",
         * 	session_secret: "de3bb6a0ebd7cd881385c71010cd2ed0"
         * }
         */
        log.info("返回结果{}",result);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        if(jsonObject != null){
            String accessToken = jsonObject.getStr("access_token");
            Long expiresIn = jsonObject.getLong("expires_in");
            stringRedisTemplate.opsForValue().setIfAbsent("access_token",accessToken,expiresIn, TimeUnit.SECONDS);
        }

    }

    /**
     * 通用文字识别
     */
    /*@Test
    public void general_basic() throws IOException {
        String accessToken = stringRedisTemplate.opsForValue().get("access_token");

        String url = getURL(baiduProperties.getUrlMap().get("accurate_basic").getUrl(), accessToken);
        Map<String,Object> map = new HashMap<>();
        String encode = Base64Util.encodeToString("e:\\test.png");
        String encode1 = URLEncoder.encode(encode, "UTF-8");
        map.put("image",encode);
        String result = HttpUtil.post(url, map);

        log.info("通用文字识别结果:{}",result);

    }*/

    /**
     *
     * @param general_basic
     * @param accessToken
     */
    private String getURL(String general_basic, String accessToken) {
        StringBuilder sb = new StringBuilder();
        sb.append(general_basic);
        sb.append("?");
        sb.append("access_token=");
        sb.append(accessToken);
        return  sb.toString();
    }

    @Test
    public void login(){
        String url = "http://10.8.20.22:8181/clife-estate-api-web-admin/common/admin/loginCheck.do";
        JSONObject jsonObject = new JSONObject();
        /**
         * username: admin
         * password: ZTEwYWRjMzk0OWJhNTlhYmJlNTZlMDU3ZjIwZjg4M2U=
         * code: 1
         */
        jsonObject.put("username","admin");
        jsonObject.put("password","ZTEwYWRjMzk0OWJhNTlhYmJlNTZlMDU3ZjIwZjg4M2U=");
        jsonObject.put("code",1);
        //链式构建请求
        HttpResponse httpResponse = HttpRequest.post(url)
                .form(jsonObject)//表单内容
                .timeout(20000)//超时，毫秒
                .execute();

        List<HttpCookie> cookies = httpResponse.getCookies();
        log.info("请求cookies列表:{}",cookies);

        String result = httpResponse.body();
        log.info("请求结果返回值:{}",result);


    }


}
