package com.expense.Sulaah.service;

import com.expense.Sulaah.entity.Group;
import com.expense.Sulaah.entity.User;

import java.util.List;

public interface GroupService {
    public Group addGroup(Group group);
    public Group getGroup(int groupId);
    public String addMembers(int groupId, List<User> users);
}
