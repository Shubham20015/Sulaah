package com.expense.Sulaah.service;

import java.util.List;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;

public interface GroupService {
    public Group createGroup(Group group);
    public Group getGroupById(int groupId);
    public String addMembers(int groupId, List<User> users);
}
