package ru.gb.antonov.j75.dtos.errorhandlers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

//@Data  < в общем модуле (и в дюбом модуле многомодульного проекта, на который кто-то ссылается
//         следует избегать автогенерации кода при пом ломбока и ему подобных утилит.)
public class ErrorMessage
{
    private List<String> messages;
    private Date         date;

//---------------- конструкторы -----------------------------------
    public ErrorMessage(){}
    public ErrorMessage (List<String> strings)
    {
        messages = strings;
        date = new Date();
    }
    public ErrorMessage (String text) { this (List.of(text)); }
    public ErrorMessage (String ... messages)  { this (Arrays.asList(messages)); }
//---------------- геттеры и сесстеры -----------------------------
    public List<String> getMessages() {   return Collections.unmodifiableList (messages);   }
    public void setMessages (List<String> messages)    { this.messages = messages; }

    public Date getDate () { return date; }
    public void setDate (Date date) { this.date = date; }
}
