INSERT INTO order_items (order_id, item_id)
SELECT id, 1 FROM orders;

INSERT INTO order_items (order_id, item_id)
SELECT id, 2 FROM orders;