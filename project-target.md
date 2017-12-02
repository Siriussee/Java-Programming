# 项目构想

## 日程管理系统

- 基础需求参考大一软件工程实训 Agenda 项目需求，简化功能参考 Android 的 calendar APP。
http://my.ss.sysu.edu.cn/wiki/pages/viewpage.action?pageId=581632011


- JavaFX8 UI 设计
http://code.makery.ch/library/javafx-8-tutorial/zh-cn/part1/

- MVC 设计模式（在JFX中已经包含）

## 对于 Agenda 需求的简化（根本就是更加复杂了啊扑街!

- 只使用一个用户，
    - 可以考虑在后续构建网络编程模块的时候，允许多个用户登录(不考虑了，真的多)

- 对于 会议 的概念，转化为 事项event和提醒reminder和目标goals
    - event 占据时间线一段的主体，是日程管理系统的主要组成部分
        - label **
        - 起止时间
        - 地点
        - 提前提醒（reminder）
        - （可能还有）邀请参与/note/attachment
    - reminder 只是时间线上的一点，
    - goals 不指定具体起止时间的 event ，具体的起止时间由用户提出模糊时间（上午下午晚上）和频率（几天一次），程序自动依照现有的时间规划，安排适当的重复性 event

- timeline
    - 以线性顺序构建一个事件的栈，这个应该是作为程序的主界面，自动完成的功能

- sort/search
    - 对于事件类型进行分类，筛选（就像ehviewer选catalog一样）
    - 根据事件名称搜索事件

- statistics
    - 根据标签统计频率
    - 根据某天/周/月统计你到底有多忙