<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Add new cloth</h2>
                    <div class="card-body">
                        <div class=" mt-3 ">
                            <form action="/addCloth" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                                <div class="form-group row text-right align-items-center"><label class="col-5"> Name : </label>
                                    <div>
                                        <input class="form-control" type="text" name="name" placeholder="Name..."/>
                                    </div>
                                </div>

                                <div class="form-group row text-right align-items-center"><label class="col-5"> Surname: </label>
                                    <div>
                                        <input class="form-control" type="number" name="price"
                                               placeholder="Price..."/>
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