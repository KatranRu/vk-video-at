Учебный проект по тестированию мобилки Android
=========================
```

```

Доработка проекта:
=========================
```
1. Создайте от develop ветку feature/*номер задачи по которой проводится доработка*
2. Назначьте MR для членов команды/community
```

Для запуска автотестов соберите проект командами:
=========================
Запуск локально на windows API тестов
```mvn
clean test -Dcucumber.filter.tags=@test "-Dcucumber.options=--plugin io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" 
allure:serve
```