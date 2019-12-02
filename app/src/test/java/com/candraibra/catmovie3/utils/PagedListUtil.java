/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 12:07 AM
 *
 */

package com.candraibra.catmovie3.utils;

import androidx.paging.PagedList;

import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PagedListUtil {

    public static <T> PagedList<T> mockPagedList(List<T> list) {
        PagedList<T> pagedList = mock(PagedList.class);
        Answer<T> answer = invocation -> {
            Integer index = (Integer) invocation.getArguments()[0];
            return list.get(index);
        };

        when(pagedList.get(anyInt())).thenAnswer(answer);
        when(pagedList.size()).thenReturn(list.size());

        return pagedList;
    }
}
