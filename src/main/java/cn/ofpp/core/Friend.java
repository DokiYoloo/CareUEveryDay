package cn.ofpp.core;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

import static cn.hutool.core.date.DateUtil.age;

/**
 * @author DokiYolo
 * Date 2022-08-22
 */
public class Friend {

    private final String fullName;

    private final Integer howOld;

    private final String province;

    private final String city;

    private final String userId;

    private final String birthday;

    private final String loveTime;

    private final String sex;

    private final String templateId;

    public Friend(String fullName, String province, String city, String userId, String birthday, String loveTime, String sex) {
        this(fullName, province, city, userId, birthday, loveTime, sex, null);
    }

    public Friend(String fullName, String province, String city, String userId, String birthday, String loveTime, String sex, String templateId) {
        this.fullName = fullName;
        this.howOld = age(DateUtil.parse(birthday), new Date());
        this.province = province;
        this.city = city;
        this.userId = userId;
        this.birthday = birthday;
        this.loveTime = loveTime;
        this.sex = sex;
        this.templateId = templateId;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getHowOld() {
        return howOld;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getUserId() {
        return userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLoveTime() {
        return loveTime;
    }

    public String getSex() {
        return sex;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getHowLongLived() {
        return String.valueOf(DateUtil.between(new Date(), DateUtil.parse(birthday), DateUnit.DAY));
    }

    public String getNextBirthdayDays() {
        return getNextDay(DateUtil.parse(birthday));
    }

    public String getNextMemorialDay() {
        return getNextDay(DateUtil.parse(loveTime));
    }

    public static String getNextDay(DateTime dateTime) {
        dateTime = DateUtil.beginOfDay(dateTime);
        DateTime now = DateUtil.beginOfDay(new Date());
        dateTime.offset(DateField.YEAR, now.year() - dateTime.year());
        if (now.isAfter(dateTime)) {
            return String.valueOf(dateTime.offset(DateField.YEAR, 1).between(now, DateUnit.DAY));
        }
        return String.valueOf(dateTime.between(now, DateUnit.DAY));
    }

}
