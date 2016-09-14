package com.github.eduzol.service;

import java.util.List;

import com.github.eduzol.domain.Account;


public interface AccountSorter {

	void sort(List<Account> people) throws Exception;

}