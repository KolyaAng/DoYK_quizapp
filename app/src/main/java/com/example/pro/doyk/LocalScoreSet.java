package com.example.pro.doyk;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import com.example.pro.doyk.Model.UserModel;

public class LocalScoreSet {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mUserRefDatabase = database.getReference("users");

     ValueEventListener userListener = new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot dataSnapshot) {
             UserModel user = dataSnapshot.getValue(UserModel.class);
             System.out.println(user);
         }


         @Override
         public void onCancelled(DatabaseError databaseError) {
             Log.w("loadPost:onCancelled", databaseError.toException());
         }
     };

//    private ChildEventListener getChildEventListener() {
//        return new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//                if(dataSnapshot.exists()){
//
//                    String userUid = dataSnapshot.getKey();
//                    if(dataSnapshot.hasChildren()) {
//                        UserModel recipient = dataSnapshot.getValue(UserModel.class);
//                        recipient.setRecipientId(userUid);
//                        mUsersKeyList.add(userUid);
//                        leaderBoardAdapterSec1.refill(recipient);
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                if(dataSnapshot.exists()) {
//                    String userUid = dataSnapshot.getKey();
//
//                    UserModel user = dataSnapshot.getValue(UserModel.class);
//
//                    int index = mUsersKeyList.indexOf(userUid);
//                    if(index > -1) {
//                        leaderBoardAdapterSec1.changeUser(index, user);
//                    }
//
//                }
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        };
//    }
}
