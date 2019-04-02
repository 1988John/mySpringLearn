package com.foo.test.ik;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * @author Fooisart
 * @date 17:16 26-03-2019
 */
public class Test {
    public static void main(String[] args) {
        //只关注这些词性的词
        Set<String> expectedNature = new HashSet<String>() {{
            add("nr");add("v");add("vn");
            add("n");add("a");
        }};
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        String str1 = "姚明今天好伤心啊，很不高兴！想交友做饭打球有点饿了，想吃苹果，踢足球打篮球看球听歌看电影";
        Result result = ToAnalysis.parse(str1);
        System.out.println(result.getTerms());
        List<Term> terms = result.getTerms();

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
                System.out.println(word + ":" + natureStr);
            }
        }

    }
}
