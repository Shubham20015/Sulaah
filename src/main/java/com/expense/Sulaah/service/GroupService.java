package com.expense.Sulaah.service;

import java.util.List;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;

public interface GroupService {
    Group createGroup(int userId, Group group);
    Group getGroupById(int groupId);
    String addMembers(int groupId, List<Integer> userIdList);
    Group addUserToGroup(Group group, User user);
}
