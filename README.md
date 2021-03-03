# raspberryb3
一个简易版的智能家居系统，采用springboot+pi4j。

开发环境：树莓派
硬件信息：Risym声音传感器，Risym MQ-6丙烷气体传感器，DHT11温湿度传感器，无源蜂鸣器，发光二极管（若干）
开发语言：java+python
开发框架：springboot+pi4j

功能实现：
1. 灯光控制：声控灯，远程控制灯光
2. 燃气泄露报警：传感器检测到燃气泄露，蜂鸣器报警，发送短信报警
3. 温湿度数据采集及其显示
