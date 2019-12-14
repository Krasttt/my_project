<#import "common.ftlh"as c >
<@c.page>
    <div class="container-fluid">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">New order</h2>
                    <div class="card-body">
                        <form id="order" method="post" action="/createorder">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <div class="row mt-3 ">
                                <div class="col-3"></div>
                                <div class="col-6">
                                    <div class="form-group mt-2 row">
                                        <div class="col-6">
                                            <label for="model">Select model:</label>
                                        </div>
                                        <div class="col-6">
                                            <select form="order" class="form-control" id="model" name="model">
                                                <#list models as model>
                                                    <option value="${model.id}">${model.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group mt-2 row">
                                        <div class="col-6">
                                            <label for="cloth">Select cloth:</label>
                                        </div>
                                        <div class="col-6">
                                            <select form="order" class="form-control" id="cloth" name="cloth">
                                                <#list clothes as cloth>
                                                    <option value="${cloth.id}">${cloth.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group mt-2 row">
                                        <div class="col-6">
                                            <label for="cutter">Select cutter:</label>
                                        </div>
                                        <div class="col-6">
                                            <select form="order" class="form-control" id="cutter" name="cutter">
                                                <#list cutters as cutter>
                                                    <option value="${cutter.id}">${cutter.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="text-center">
                                        <button class="btn btn-outline-success " type="submit">Confirm</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>