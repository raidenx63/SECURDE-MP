<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/index.css" >
        <link rel="stylesheet" type="text/css" href="css/adminCreateAcc.css">
    </head>
    <body><br>
        <div class="container">
            <h2>Create an account</h2>
            <hr>

            <form role="form">
                <div class="form-group">

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="fName">First Name</label>
                            <input type="text" class="form-control" id="fName" placeholder="First Name" required>
                        </div>
                        <div class="col-sm-1">
                            <label for="mInitial">M.I.</label>
                            <input type="text" class="form-control" id="mInitial" placeholder="M.I." required>
                        </div>
                        <div class="col-sm-2">
                            <label for="lName">Last Name</label>
                            <input type="text" class="form-control" id="lName" placeholder="Last Name" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" placeholder="Username" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" id="pwd" placeholder="Password" required>
                        </div>
                        <div class="col-sm-4">
                            <label for="repwd">Re-type Password:</label>
                            <input type="password" class="form-control" id="repwd" placeholder="Re-type Password" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-5">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" placeholder="Email"required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-5">
                            <label for="type">Account Type:</label>
                            <select class="form-control" id="type" >
                                <option>Product Manager</option>
                                <option>Accounting Manager</option>
                            </select>
                        </div>
                    </div>
                </div>
                <hr>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <br>
        </div>

    </body>
</html>