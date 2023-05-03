package com.wang.orderapp.controller;

import com.wang.orderapp.domain.TArticle;
import com.wang.orderapp.mapper.TArticleMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @Author：wp
 * @Package：com.wang.orderapp.controller
 * @Project：java-Core
 * @name：WeiboController
 * @Description 实现微博点赞排行功能
 * @Date：2023/5/3 11:20
 * @Filename：WeiboController
 */

@RestController
@RequestMapping("/article")
public class WeiboController {

    @Resource
    private TArticleMapper tArticleMapper;

    @Resource
    private RedisTemplate redisTemplate;

    private static final String ARTICLE = "ARTICLE";


    @GetMapping("/insert")
    public String insertArticle() {
        int i1 = new Random().nextInt(30);
        for (int i = 0; i < i1; i++) {
            int articleId = new Random().nextInt(300);
            int like = new Random().nextInt(50);
            tArticleMapper.insert(new TArticle(1, articleId, new Date(), new Date()
                    , "https://baidu.com", "12", like));
            redisTemplate.opsForZSet().add(ARTICLE, articleId, like);

        }

        return "新增" + i1;
    }


    @GetMapping("/like/{id}")
    public String likeArticle(@PathVariable("id") Integer id) {
        //点赞加1
        redisTemplate.opsForZSet().incrementScore(ARTICLE, id, 1);
        return "like" + id;
    }

    @GetMapping("/sort")
    public Set sortArticle(){
        Set set = redisTemplate.opsForZSet().reverseRangeByScore(ARTICLE, 0, -1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println("排序后—"+iterator.next());
        }
        return set;
    }
}
