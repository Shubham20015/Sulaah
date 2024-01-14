package com.expense.Sulaah.service;

import java.util.List;

import com.expense.Sulaah.entity.Group;

public interface GroupService {
    public Group createGroup(int userId, Group group);
    public Group getGroupById(int groupId);
    public String addMembers(int groupId, List<Integer> userIdList);
}
