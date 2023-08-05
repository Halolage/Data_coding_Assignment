## SQL Query to run to save update to database 

```
UPDATE tblSubscriptionInfo
SET customer_contact_phone = "updated_contact_number"
WHERE customer_id = desired_customer_id;
```

## How to speed up update query 

- 1\. Create an index for column name customer_id, so that update statement can search for the specific customer_id quickly. 
```
CREATE INDEX idx_customer_id ON tblSubscriptionInfo (customer_id);
```

- 2\. Caching. Implement caching mechanisms at the application level to reduce the frequency of update queries. Cache frequently accessed customer data, including contact phone numbers, to reduce the need for frequent updates.We can start with configuring a caching library or framework. 

- 3\. Database Partitioning. Depending on the size of your table, consider partitioning it based on certain criteria (e.g., customer ID ranges) to improve query performance.

- 4\. Database Sharding. If your application has a large number of customers, sharding the database based on some criteria (e.g., customer regions) can distribute the load and improve update performance.


## Come up with the queries to find:

- 1\. number of subscribers whose subscriptions will be ending in 2023:
```
SELECT COUNT(*) AS num_subscribers_ending_2023
FROM tblSubscriptionInfo
WHERE YEAR(subscription_end_date) = 2023;
```

- 2\. number of subscribers who have subscribed for more than 3 months in 2022;
```
SELECT COUNT(*) AS num_subscribers_longer_than_3_months_2022
FROM tblSubscriptionInfo
WHERE YEAR(subscription_start_date) = 2022
  AND DATEDIFF(MONTH, subscription_start_date, subscription_end_date) > 3;
```

- 3\. subscribers who have subscribed for more than two products;
```
SELECT customer_id, customer_name
FROM tblSubscriptionInfo
GROUP BY customer_id, customer_name
HAVING COUNT(DISTINCT product_id) > 2;
```
