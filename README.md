### 更新记录:  
0826: 临时移除一言随机古诗的动态获取，有超时问题等待换接口  



最近在抖音上的看到挺多人发的
然后就自己随便做了一个玩了一下

本项目不需要服务器
基于Github Actions实现每天固定运行一次 需注意GithubActions使用的UTC时间 转换为北京时间需要-8小时处理

`友情提示：master分支github actions执行规则是每天早上7点自动执行`
`如果需要监听推送执行 请切换workflow_on_push分支`

博客可能有些慢 我将内容移植到了语雀笔记 国内访问会很快
[点击访问语雀笔记](https://www.yuque.com/docs/share/66a239d8-f272-4a90-81bc-b2f5e30ccce6#3cfdeb22)


为了照顾小白，特地写了一篇完整详细的详细教程放到了我的博客以供参考
[点击访问我的博客](https://blog.ofpp.cn)

由于 博客服务器托管在GitPage节点在国外且前段时间cdn到期了 可能会访问比较慢～

![效果展示](https://static.marketup.cn/marketup/company/151/2022/822/cu/2809847835962369/20220822233123039-kesngm1h01iu.jpeg)
 
 
#### 公众号模板内容 可以根据自己的需要变更内容
```text
你叫{{friendName.DATA}}
今年{{howOld.DATA}}
距离下一次生日{{nextBirthday.DATA}}天
具体我们的下一次纪念日{{nextMemorialDay.DATA}}天
现在在{{province.DATA}}{{city.DATA}}
当前天气{{weather.DATA}}
当前气温{{temperature.DATA}}
风力描述{{winddirection.DATA}}
风力级别{{windpower.DATA}}
空气湿度{{windpower.DATA}}
{{author.DATA}}
{{origin.DATA}}
{{content.DATA}}
```
其中
```text
{{author.DATA}}
{{origin.DATA}}
{{content.DATA}}
```
是古诗的变量，如果`Bootstrap`中配置未开启随机古诗 那么这三个就是不要的


#### 核心类介绍

```
Application.java          // 启动类
Bootstrap.java            // 一些启动配置(公众号信息在这里配置)
core/MessageFactory.java  // 创建微信消息对象的代码就在这里面 有需要可以自己修改下变量
```
