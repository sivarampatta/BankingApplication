package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	  public List<Account> getAllAccounts() {
	        return accountRepository.findAll();
	    }

	    public Optional<Account> getAccountById(Long id) {
	        return accountRepository.findById(id);
	    }

	    public Account createAccount(Account account) {
	        return accountRepository.save(account);
	    }


	    public Account updateAccount(Long id, Account updatedAccount) {
	        return accountRepository.findById(id).map(account -> {
	            account.setAccountHolderName(updatedAccount.getAccountHolderName());
	            account.setAccountNumber(updatedAccount.getAccountNumber());
	            account.setBalance(updatedAccount.getBalance());
	            return accountRepository.save(account);
	        }).orElseThrow(() -> new RuntimeException("Account not found!"));
	    }

	    public void deleteAccount(Long id) {
	        accountRepository.deleteById(id);
	    }

		
	}


