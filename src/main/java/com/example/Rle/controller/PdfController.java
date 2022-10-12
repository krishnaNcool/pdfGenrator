package com.example.Rle.controller;

import com.example.Rle.sevice.PdfGenrator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/invoice/pdf")
@AllArgsConstructor
public class PdfController {

    @Autowired
    private PdfGenrator pdfGenrator;

    @GetMapping("/{pdfName}")
    public void genaratePDF(@PathVariable  String pdfName) throws Exception {
        pdfGenrator.pdf(pdfName);

    }
}
