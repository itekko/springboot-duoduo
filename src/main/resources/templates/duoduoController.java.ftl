package ${package.Controller};


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import java.util.List;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if swagger2>
@Api("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${controllerMappingHyphen}Service;

    /**
     * ${table.comment!}查询
     * @return
     */
    @Log("${table.comment!}查询")
    @GetMapping("/{id}")
    <#if swagger2>
    @ApiOperation("${table.comment!}查询")
    </#if>
    public Result<${entity}> get(@PathVariable("id") Long id){
        return Result.ok(${controllerMappingHyphen}Service.getById(id));
    }

    /**
     * ${table.comment!}列表查询(分页)
     * @return
     */
    @Log("${table.comment!}列表查询(分页)")
    @GetMapping("/page")
    <#if swagger2>
    @ApiOperation("${table.comment!}列表查询(分页)")
    </#if>
    public Result<IPage<${entity}>> page(@RequestBody ${entity} ${controllerMappingHyphen}){
        Page<${entity}> page = new Page<>(${controllerMappingHyphen}.getCurrent(), ${controllerMappingHyphen}.getSize());
        return Result.ok(${controllerMappingHyphen}Service.page(page,new QueryWrapper<>(${controllerMappingHyphen})));
    }

    /**
     * ${table.comment!}列表查询
     * @return
     */
    @Log("${table.comment!}列表查询")
    @GetMapping("/list")
    <#if swagger2>
    @ApiOperation("${table.comment!}列表查询")
    </#if>
    public Result<List<${entity}>> list(@RequestBody ${entity} ${controllerMappingHyphen}){
        return Result.ok(${controllerMappingHyphen}Service.list(new QueryWrapper<>(${controllerMappingHyphen})));
    }

    /**
     * 新增
     * @param ${controllerMappingHyphen}
     * @return
     */
    @Log("${table.comment!}新增")
    @PostMapping
    <#if swagger2>
    @ApiOperation("${table.comment!}新增")
    </#if>
    public Result add(@RequestBody ${entity} ${controllerMappingHyphen}){
        return Result.ok(${controllerMappingHyphen}Service.save(${controllerMappingHyphen}));
    }



    /**
     * 修改
     * @param id
     * @param ${controllerMappingHyphen}
     * @return
     */
    @Log("${table.comment!}修改")
    @PutMapping("/{id}")
    <#if swagger2>
    @ApiOperation("${table.comment!}修改")
    </#if>
    public Result update(@PathVariable("id") Long id, @RequestBody ${entity} ${controllerMappingHyphen}){
        return Result.ok(${controllerMappingHyphen}Service.updateById(${controllerMappingHyphen}));
    }

    /**
     * ${table.comment!}删除
     * @param id
     * @return
     */
    @Log("${table.comment!}删除")
    @DeleteMapping("/{id}")
    <#if swagger2>
    @ApiOperation("${table.comment!}删除")
    </#if>
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(${controllerMappingHyphen}Service.removeById(id));
    }

}
</#if>
