package com.houle.mapper;

import com.houle.pojo.Blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 新增一个博客
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIf(HashMap<String, String> map);

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

}
