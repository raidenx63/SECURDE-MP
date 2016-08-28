
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="css/normalizeREGISTRATION.css">
        <link rel="stylesheet" href="css/styleREGISTRATION.css">
    </head>
    <body>

        <form action="registerServlet" method="post">

            <h1>Sign Up</h1>

            <fieldset>
                <legend><span class="number"></span>Your basic info</legend>
                <label> First Name:</label>
                <input type="text" id="fname" name="fname">

                <label> Middle Initial:</label>
                <input type="text" id="mname" name="mname">

                <label> Last Name:</label>
                <input type="text" id="lname" name="lname">

                <label> User Name:</label>
                <input type="text" id="username" name="username">

                <label> Password:</label>
                <input type="password" id="password" name="password">

                <label> Email:</label>
                <input type="email" id="email" name="email">         

                <label> Billing Address:</label>
                <input type="text" id="billing_address" name="billing_address">

                <label> Shipping Address:</label>
                <input type="text" id="shipping_address" name="shipping_address">





            </fieldset>

            <!-- <fieldset>
              <legend><span class="number">2</span>Billing Address</legend>
    
    
              <label> House Number: </label>
              <input type="text" id="billing_hnum" name="billing_hnum">
    
              <label>Street:</label>
              <input type="text" id="billing_street" name="billing_street">
    
              <label>Subdivision:</label>
              <input type="text" id="billing_subdivision" name="billing_subdivision">
    
              <label>City:</label>
              <input type="text" id="billing_city" name="billing_city">
    
              <label>Postal Code:</label>
              <input type="text" id="billing_postalcode" name="billing_postalcode">
    
              <label>Country:</label>
              <input type="text" id="billing_country" name="billing_country">
            </fieldset>
    
             <fieldset>
              <legend><span class="number">3</span>Shipping Address</legend>
    
    
              <label> House Number: </label>
              <input type="text" id="shipping_hnum" name="shipping_hnum">
    
              <label>Street:</label>
              <input type="text" id="shipping_street" name="shipping_street">
    
              <label>Subdivision:</label>
              <input type="text" id="shipping_subdivision" name="shipping_subdivision">
    
              <label>City:</label>
              <input type="text" id="shipping_city" name="shipping_city">
    
              <label>Postal Code:</label>
              <input type="text" id="shipping_postalcode" name="shipping_postalcode">
    
              <label>Country:</label>
              <input type="text" id="shipping_country" name="shipping_country">
            </fieldset> -->


        </fieldset>
        <button type="submit" value="Submit">Sign Up!</button>
    </form>

</body>
</html>

