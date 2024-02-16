package com.expense.Sulaah.service;

import java.util.List;

import com.expense.Sulaah.entity.Group;

public interface GroupService {
    Group createGroup(int userId, Group group);
    Group getGroupById(int groupId);
    String addMembers(int groupId, List<Integer> userIdList);
}
