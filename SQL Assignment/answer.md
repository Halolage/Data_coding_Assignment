-- SQL Query to run to save update to database --
```
UPDATE tblSubscriptionInfo
SET customer_contact_phone = "updated_contact_number"
WHERE customer_id = desired_customer_id;
```

-- How to speed up update query --
- 1\. Create an index for column name customer_id, so that update statement can search for the specific customer_id quickly. 
```
CREATE INDEX idx_customer_id ON tblSubscriptionInfo (customer_id);
```

- 2\. Caching. Implement caching mechanisms at the application level to reduce the frequency of update queries. Cache frequently accessed customer data, including contact phone numbers, to reduce the need for frequent updates.We can start with configuring a caching library or framework. 

