package org.dmc30.OCprojet6.business.impl.manager;

public class labo {

    // transaction => pilule bleu
//    @Override
//    public void createUsers(Users pUsers) {
//        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
//        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                getDaoFactory().getUsersDao().createUsers(pUsers);
//                getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername());
//            }
//        });
//    }

    // transaction => pilule bleu avec rollback
//    @Override
//    public void createUsers (Users pUsers) {
//        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
//        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
//           try {
//               getDaoFactory().getUsersDao().createUsers(pUsers);
//               getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername());
//           }
//           catch (TechnicalException vEx ) {
//               pTransactionStatus.setRollbackOnly();
//           }
//            }
//        });
//    }
}
