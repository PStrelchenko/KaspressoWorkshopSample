package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl

@TestCaseDslMarker
class PostDsl(
    val uniqueTestId: String,
    val userId: Int,
    var id: Long = 1L,
    var title: String = "Test title $uniqueTestId",
    var body: String = "Test body $uniqueTestId"
)