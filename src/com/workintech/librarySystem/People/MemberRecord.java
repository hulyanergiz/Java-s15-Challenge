package com.workintech.librarySystem.People;

import java.util.Date;

public class MemberRecord {
    private String memberId;
    private String name;
    private Date dateOfMemberShip;
    private int noBooksIssued;
    private final int maxBookLimit=5;
    private String address;
    private String phoneNumber;

    public MemberRecord(String memberId, String name, Date dateOfMemberShip, int noBooksIssued, String address, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.dateOfMemberShip = dateOfMemberShip;
        this.noBooksIssued = noBooksIssued;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfMemberShip() {
        return dateOfMemberShip;
    }

    public void setDateOfMemberShip(Date dateOfMemberShip) {
        this.dateOfMemberShip = dateOfMemberShip;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void incBookIssued(){
        if(noBooksIssued<maxBookLimit){
            noBooksIssued++;
        }else{
            System.out.println("Max book limit reached, cannot issue more books.");
        }
    }

    public void decBookIssued(){
        if(noBooksIssued>0){
            noBooksIssued--;
        }else{
            System.out.println("No books to return.");
        }
    }
    public boolean canBarrowBook(){
        return noBooksIssued<maxBookLimit;
    }
    public void payBill(){
        System.out.println("Bill is paid for borrowing a book.");
    }
    public void refundForReturning(){
        System.out.println("Refund is issued for returning a book.");
    }
}
