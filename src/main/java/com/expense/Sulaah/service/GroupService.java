package com.expense.Sulaah.service;

import java.util.List;

import com.expense.Sulaah.entity.Group;

public interface GroupService {
    Group createGroup(int userId, String name);
    Group getGroupById(int groupId) throws RuntimeException;
    Group addMembers(int groupId, List<Integer> userIdList) throws RuntimeException;
}
