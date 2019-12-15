<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Clothes
                        <a href="/addCloth" class="btn btn-success mt-2 float-right">Add cloth</a></h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">
                            <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th scope="col" class="col">Name</th>
                                <th scope="col" class="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list clothes as cloth>
                                <tr>
                                    <th scope="row">${cloth.id}</th>
                                    <td>${cloth.name}</td>
                                    <td>${cloth.price}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>