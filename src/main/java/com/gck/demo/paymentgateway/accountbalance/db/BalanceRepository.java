package com.gck.demo.paymentgateway.accountbalance.db;

import com.gck.demo.paymentgateway.accountbalance.models.Balance;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

// --- Commented out for Quarkus Migration
// import org.springframework.data.mongodb.repository.MongoRepository;

// --- Commented out for Quarkus Migration
// public interface BalanceRepository extends MongoRepository<Balance, String> {
@ApplicationScoped
public class BalanceRepository implements PanacheMongoRepository<Balance> {
	// --- Commented out for Quarkus Migration
	// Balance findByAccountId(String accountId);
	public Balance findByAccountId(String accountId){
		return find("accountId", accountId).firstResult();
	}

}
