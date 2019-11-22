package com.hanrabong.web.pxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data 
@Lazy
public class KyjProxy{
    @Autowired Trunk trunk;
    public List<List<String>> naverWord(){
        List<List<String>> list = new ArrayList<>();
        String url = "https://endic.naver.com/?sLn=kr";
        String node = "a[class=word_link]";
        String node2 = "div[class=txt_trans]";
        try {
            Document rawData;
            rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements word = rawData.select(node);
            Elements text = rawData.select(node2);
            System.out.println("단어:"+word.text());
            System.out.println("뜻:"+text.text());
       
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            for(Element e : word) {
          
                list1.add(e.text());
                
            }
            for(Element e : text) {
             
                list2.add(e.text());
            }
            
            list.add(list1);
            list.add(list2);
            
            
            /*for(int i = 0; i<list1.size(); i++) {
                map.clear();
                map.put("word", list1.get(i));
                map.put("text", list2.get(i));
                list.add(map);
            }*/
            
/*
            for(int i = 0; i<4; i++) {
                map = new HashMap<>();
                for(Element e : word) {
                    map.put("k1",e.text());
                }
                for(Element e2 : text) {
                    map.put("k2", e2.text());
                }
                list.add(map);
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}