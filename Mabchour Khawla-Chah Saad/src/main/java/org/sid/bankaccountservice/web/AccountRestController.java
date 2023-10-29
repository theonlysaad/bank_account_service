package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.BankAccountServiceApplication;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepositpry;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepositpry bankAccountRepositpry;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepositpry bankAccountRepositpry) {
        this.bankAccountRepositpry = bankAccountRepositpry;
        this.accountService=accountService;
        this.accountMapper= accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepositpry.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepositpry.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id ,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepositpry.findById(id).orElseThrow();
        if (account.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if (account.getCreateAt()!=null)account.setCreateAt(new Date());
        if (account.getType()!=null)account.setType(bankAccount.getType());
        if (account.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepositpry.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepositpry.deleteById(id);
    }



}
