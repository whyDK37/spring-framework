
#c7 aop
   calc包  spring aop introduction,可以让一个接口实现动态的实现其它接口。
         通过这种方式，我们可以动态的为bean增加状态，如使用 DeclareParents 扩展 bean功能，再通过 aop 切面修改或监控状态。

   如果想通过xml方式配置声名aspectj，<aop:aspectj-autoproxy />是不必要的，应该删除，这样spring 将会忽略 AspectJ注解。
   配置的方式大体就是把注解的信息通过xml配置而已，这里就不再赘述了。