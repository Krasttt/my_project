<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Add new model</h2>
                    <div class="card-body">
                        <div class=" mt-3 ">
                            <form action="/addModel" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                                <div class="form-group row text-right align-items-center"><label class="col-5"> Name : </label>
                                    <div>
                                        <input class="form-control" type="text" name="name" placeholder="Name..."
                                               minlength="3" maxlength="25" required/>
                                    </div>
                                </div>

                                <div class="form-group row text-right align-items-center"><label class="col-5"> Price: </label>
                                    <div>
                                        <input class="form-control" type="number" name="price"
                                               placeholder="Price..."
                                        min="1" max="10000" required/>
                                    </div>
                                </div>

                                <div class="form-group row text-right align-items-center"><label class="col-5"> Cloth size: </label>
                                    <div>
                                        <input class="form-control" type="number" name="clothSize"
                                               placeholder="Cloth size..."
                                        min="1" max="100" required/>
                                    </div>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-primary float-right">Add cutter</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</@c.page>