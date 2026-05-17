package org.example.orderms.enums;

public enum Status {
    CREATED,            // order yaradıldı
    PENDING,    // payment gözlənilir
    SUCCESS,  // payment uğurlu oldu
    FAILED,     // payment uğursuz oldu
    COMPLETED,          // bütün proses bitdi
    CANCELLED           // rollback edildi
}
