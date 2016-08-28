<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Talaria Shoe Company</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/index.css" >
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <script src="jquery-3.1.0.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {

                $("#regButton").click(function(){
                    $("#belowmenubar").load("registration.jsp");
                });
                
                $("#loginForm").submit(function event() {
                    event.preventDefault();

                    var $form = $(this);

                    var request = $.ajax({
                        type: $form.attr('method'),
                        url: $form.attr('action'),
                        data: $form.serialize()
                    });
                    
                    request.done(function(data){
                        $("#belowmenubar").html(data);
                    });
                    
                    request.fail(function(jqXHR, textStatus){
                        alert( "Request failed: " + textStatus );
                    });
                })
            });

        </script>
    </head>
    <body>
        <!--HEADER-->
        <nav class="navbar navbar-default navbar-inverse" style="border-radius:0px !important; margin-bottom: 0px;">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Talaria Shoe Company</a> <!--change to index.jsp once database is implemented-->
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="assets/images/img_menubutton.png"></img><span class="caret"></span></a>
                            <ul class="dropdown-menu" >
                                <form id="loginForm" action="loginServlet" method="post">
                                    <li class="loginmenu"><h5>Username: </h5><input id="uname" type="text" class="form-control" placeholder="" name="username" required="true"></li>
                                    <li class="loginmenu"><h5>Password: </h5><input id="pword" type="password" class="form-control" placeholder="" name="password" required="true"></li>
                                    <li class="loginmenu2"><input type="submit" class="btn btn-default btn-sm" value="Log-in"> <button id="regButton" type="button" class="btn btn-default btn-sm">Register</button></li>
                                </form>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!--END HEADER-->
        <!--SLIDER-->
        <div class="belowmenubar" id="belowmenubar">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="assets/images/slider/img_slider1.jpg" alt="img1">
                        <div class="carousel-caption">
                            <h1>Welcome to Talaria!</h1>
                            <p>We focus ourselves in making shoes that will undoubtedly move our customers. Our goal is to have every generation of mankind to walk using the most finest shoes ever to be crafted on Earth.</p>
                        </div>
                    </div>
                    <div class="item"> <!--do not put actvie here or the pic will overlap. Only the first item-->
                        <img src="assets/images/slider/img_slider2.jpg" alt="img2">
                        <div class="carousel-caption">
                            <h1>Get French Palladium Boots for $299 only!</h1>
                            <p>Save up to $28!</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="assets/images/slider/img_slider3.jpg" alt="img3">
                        <div class="carousel-caption">
                            <h1>Holiday Sale!</h1>
                            <p>From August 11-August 20. Sales are applicable to selected items only.</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="assets/images/slider/img_slider4.jpg" alt="img4">
                        <div class="carousel-caption" id="slider4image">
                            <h1>Manners Maketh Man</h1>
                            <p>Show your gentleman side by collecting these three formal oxford shoes and get a free dark gray boatshoes.</p>
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only"></span>
                    <img src="assets/images/img_prevbutton.png">
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only"></span>
                    <img src="assets/images/img_nextbutton.png">
                </a>
            </div>
            <!--SLIDER-->
            <div class="space"></div>
            <div class="categoriescontainer">
                <!--CATEGORIES ROW-->
                <div class="row categories">
                    <div class="col-md-4 col-sm-4 col-xs-12 firstcategory">
                        <!--<img src="assets/images/thumb140.jpg" alt="category01" class="img-rounded">-->
                        <h2>Boots</h2>
                        <p>Style yourself in any season with our perfectly-made luxurious but indestructible boots.</p>
                        <form action="categoryServlet" method="post">
                            <input type="hidden" name="footType" value="0"/>
                            <input type="submit" value="Check category" class="btn btn-default"/>
                        </form>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 secondcategory">
                        <!--<img src="assets/images/thumb140.jpg" alt="category01" class="img-rounded">-->
                        <h2>Shoes</h2>
                        <p>Check out our famous collection of formal, casual and sport shoes that will never go out of style.</p>
                        <a href="#" class="btn btn-default">Check category</a>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 thirdcategory">
                        <!--<img src="assets/images/thumb140.jpg" alt="category01" class="img-rounded">-->
                        <h2>Sandals</h2>
                        <p>Look extra hot in the summer heat with our wide array of expertly crafted sandals.</p>
                        <a href="#" class="btn btn-default">Check category</a>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 fourthcategory">
                        <!--<img src="assets/images/img_slippersbanner.jpg" alt="Slippers" class="img-rounded">-->
                        <h2>Slippers</h2>
                        <p>Cozy up with the best slippers on the planet that will make your feet relaxed and comfortable under any circumstances.</p>
                        <a href="#" class="btn btn-default">Check category</a>
                    </div>
                </div>
                <!--CATEGORIES ROW-->
                <hr class="divider" align="center">

            </div>
        </div>

        <footer>
            <p class = "pull-right" id="backtotop"><a href="#">Back To Top</a></p>
            <p id="designedby">Designed by Borja, Hosoya, Pangilinan, Uy. <a href = "#">Privacy</a>. <a href="#">Terms</a></p>
        </footer>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>