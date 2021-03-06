package awd.cloud.platform.servers.analyse.service.kss;

import awd.cloud.platform.servers.analyse.dao.kss.JGRYSYDao;
import awd.framework.common.datasource.api.annotation.UseDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Author：YaoBen
 * Date：2019-11-13 13:14
 * Description：<描述>
 */

@Service
public class Kss_JGRYSYService {

    @Autowired
    private JGRYSYDao jgrysyDao;

    //全市被监管人员收押情况 看守所 日


    @UseDataSource("kss_ds")
    public ArrayList<Object> find_JGRYSY() {


        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        instance.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");


        ArrayList<HashMap<String, Object>> list1 = jgrysyDao.select_JGRYSY();
        ArrayList<Object> list2 = new ArrayList<>();

        for (int i = 8; i >= 0; i--) {
            instance.add(Calendar.DATE, -i);

            HashMap<String, Object> map = new HashMap<>();
            for (int j = 0; j < list1.size(); j++) {
                String rq = null;
                rq = list1.get(j).get("rq").toString();

                Date parseDate = null;
                try {

                    parseDate = format2.parse(rq);

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                if (format.format(instance.getTime()).equals(format.format(parseDate))) {
                    map.put("name", format.format(instance.getTime()));

                    map.put("value", list1.get(j).get("sl"));
                    System.out.println("value=="+list1.get(j).get("sl"));
                    continue;

                }
                if (!format.format(instance.getTime()).equals(format.format(parseDate))) {
                    map.put("name", format.format(instance.getTime()));

                    map.put("value", 0);

                }
            }

            list2.add(map);

            instance.clear();
            instance.setTime(date);
        }

        return list2;


    }
}