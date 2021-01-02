package com.alan.pms.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.suggest.Suggester;

import java.util.List;

/**
 * @Author: Alan
 * @Date: 2020/12/30 23:33
 */
public class NlpUtils {
    public static void main(String[] args) {

    }

    /**
     *基于智能推荐和短语提取的内容提取工具类
     * @param content
     * @return
     */
    public static String detectContent(String content){
        List<String> phraseList=getPhrase(content);
        List<String> mainIdeaList=getMainIdea(content);

        boolean isStop=false;
        String str=null;
        for (String phrase:phraseList
        ) {
            if (!isStop) {
                for (String mainIdea:mainIdeaList
                ) {
                    if (phrase.indexOf(mainIdea)>=0&&!isStop) {
                        str=phrase;
                        System.out.println(str);
                        isStop=true;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }

        return StringUtils.safeString(str);
    }


    /**
     * 关键字提取
     */
    public static List<String> getMainIdea(String content) {
        return HanLP.extractKeyword(content, 5);
    }

    /**
     * 短语提取
     */
    public static List<String> getPhrase(String text) {
        return  HanLP.extractPhrase(text, 10);
    }

    public static void getZhaiYao(String content) {
        List<String> sentenceList = HanLP.extractSummary(content, 3);
        System.out.println("自动摘要："+sentenceList);
    }

    /**
     * 智能推荐
     */
    public static void getSegement() {
        Suggester suggester = new Suggester();
        String[] titleArray = ("张小泉菜刀家用厨师专用菜刀套装切片刀具厨房不锈钢菜刀切菜刀\n" + "菜刀" + "张小泉思优普专卖店\n"
                + "").split("\\n");
        for (String title : titleArray) {
            suggester.addSentence(title);
        }

    }

}
