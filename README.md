**Test Case Shopping Cart Functionality**

| **Test Case ID**    | TC001                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that a product can be added to the shopping cart. |
| **Preconditions**    | User is on the home page.                    |
| **Test Steps**       | 1. Log in to the website. <br> 2. Search for a specific product. <br> 3. Click the "Add to Cart" button. |
| **Expected Result**  | Product is successfully added to the shopping cart. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC002                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the user can continue shopping after adding items to the cart. |
| **Preconditions**    | User has already added a product to the cart. |
| **Test Steps**       | 1. Add a product to the cart. <br> 2. Navigate back to the product listing page. <br> 3. Search for and add another product to the cart. |
| **Expected Result**  | Users can continue shopping, and multiple products are added to the cart without issues. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC003                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the quantity of an item in the cart is incremented if the user clicks the “+” button in the cart page. |
| **Preconditions**    | User has already added a product to the cart. |
| **Test Steps**       | 1. Add a specific product to the cart. <br> 2. Add the same product to the cart again. |
| **Expected Result**  | Quantity of the product in the cart increases, and the total price is updated accordingly. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC004                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the total amount of all items in the cart is displayed to the user. |
| **Preconditions**    | User has added multiple items to the cart.    |
| **Test Steps**       | 1. Add multiple products to the cart. <br> 2. View the cart. |
| **Expected Result**  | Total amount for all items in the cart is displayed accurately. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC005                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that when the user clicks the "Remove" button, the item is removed from the cart. |
| **Preconditions**    | User has items in the cart.                   |
| **Test Steps**       | 1. Add a product to the cart. <br> 2. Navigate to the cart. <br> 3. Click the "Remove" button next to the product. |
| **Expected Result**  | Product is removed from the cart, and the cart total is updated accordingly. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC006                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the cart displays a message when an item is removed. |
| **Preconditions**    | User has items in the cart.                   |
| **Test Steps**       | 1. Add a product to the cart. <br> 2. Navigate to the cart. <br> 3. Click the "Remove from Cart" button next to the product. |
| **Expected Result**  | A confirmation message is displayed stating that the item has been removed. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC007                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the cart displays a message when it is empty. |
| **Preconditions**    | User has the cart empty.                      |
| **Test Steps**       | Navigate to the cart without adding any products. |
| **Expected Result**  | A message such as "Your cart is empty" is displayed. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC008                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the items in the cart remain present if the user logs out and logs in again. |
| **Preconditions**    | User has a registered account and items in the cart. |
| **Test Steps**       | 1. Add products to the cart. <br> 2. Log out of the account. <br> 3. Log back into the account. <br> 4. Navigate to the cart. |
| **Expected Result**  | Items added to the cart before logging out are still present. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC009                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the cart displays the correct total price after adding multiple items. |
| **Preconditions**    | User has multiple products added to the cart. |
| **Test Steps**       | 1. Add multiple products to the cart. <br> 2. Check the total price displayed in the cart. |
| **Expected Result**  | Total price is calculated correctly.         |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC010                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that an unavailable product cannot be added to the cart. |
| **Preconditions**    | Product is unavailable.                      |
| **Test Steps**       | 1. Search for an out-of-stock product. <br> 2. Attempt to add it to the cart. |
| **Expected Result**  | A message is displayed, and the product is not added. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC011                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the quantity of a product can be updated in the cart. |
| **Preconditions**    | Product is added to the cart.                |
| **Test Steps**       | 1. Go to the shopping cart. <br> 2. Change the quantity of the product. |
| **Expected Result**  | Quantity is updated, and total price is recalculated. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC012                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that a logged-in user can add a product to the cart. |
| **Preconditions**    | User has a registered account.               |
| **Test Steps**       | 1. Browse the website as a guest. <br> 2. Add a product to the cart. |
| **Expected Result**  | Product is successfully added to the cart.   |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC013                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that product details (name, image, and price) are displayed correctly in the cart. |
| **Preconditions**    | User's products have been added to the cart.  |
| **Test Steps**       | 1. Log in to the website. <br> 2. Add one or more products to the cart. <br> 3. Navigate to the cart and view the product details. |
| **Expected Result**  | The product name, image, and price are displayed accurately for each item in the cart. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC014                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that the cart can handle large quantities of a single product without errors. |
| **Preconditions**    | Users have the product available in large quantities. |
| **Test Steps**       | 1. Add product to the cart. <br> 2. Increment the quantity of the product to a high number (e.g., 1000). <br> 3. Check the cart's behavior and total price calculation. |
| **Expected Result**  | The cart updates the quantity and total price accurately without errors or performance issues. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |

| **Test Case ID**    | TC015                                         |
|---------------------|-----------------------------------------------|
| **Test Description** | Verify that multiple different products can be added to the shopping cart in a single session. |
| **Preconditions**    | User is on the home page.                    |
| **Test Steps**       | 1. Search for and add a product (Product A) to the cart. <br> 2. Search for and add another product (Product B) to the cart. <br> 3. Repeat the process for a third product (Product C). <br> 4. Navigate to the cart. |
| **Expected Result**  | All selected products (Product A, Product B, and Product C) are added to the cart, each displayed with correct quantities and prices. |
| **Actual Result**    | N/A                                           |
| **Status**           | N/A                                           |
