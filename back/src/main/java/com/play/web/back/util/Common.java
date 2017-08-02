package com.play.web.back.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/8/2
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class Common {

    public static boolean isEmpty(List<String> noCacheMethod) {
        if (noCacheMethod == null || noCacheMethod.size() < 1)
            return true;
        return false;
    }

    public static boolean isEmpty(Object[] args) {
        if (args == null || args.length < 1)
            return true;
        return false;
    }

}
