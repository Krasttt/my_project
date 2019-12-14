<#import "common.ftlh"as c >
<@c.page>
<div class="container-fluid">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <div class="card mt-5 ">
                <h2 class="card-header text-center ">Registration</h2>
                <div class="card-body">
                    <div class=" mt-3 ">
                        <form action="/registration" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                            <div class="form-group row text-right align-items-center"><label class="col-5"> Login : </label>
                                <div>
                                    <input class="form-control" type="text" name="username" placeholder="Login..."/>
                                </div>
                            </div>

                            <div class="form-group row text-right align-items-center"><label class="col-5"> Password: </label>
                                <div>
                                    <input class="form-control" type="password" name="password"
                                           placeholder="Password..."/>
                                </div>
                            </div>

                            <div class="form-group row text-right align-items-center"><label class="col-5"> Confirm password: </label>
                                <div>
                                    <input class="form-control" type="password" name="confirmPassword" placeholder="Confirm password..."/>
                                </div>
                            </div>

                            <div class="form-group row text-right align-items-center"><label class="col-5"> Name: </label>
                                <div>
                                    <input class="form-control" type="text" name="name" placeholder="Name..."/>
                                </div>
                            </div>

                            <div class="form-group row text-right align-items-center"><label class="col-5"> Surname: </label>
                                <div>
                                    <input class="form-control" type="text" name="surname" placeholder="Surname..."/>
                                </div>
                            </div>

                            <div>
                                <a href="/login" class="btn btn-outline-success">Go to Login</a>
                                <button type="submit" class="btn btn-primary float-right">Registration!</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>