<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output encoding="utf-8"/>

    <xsl:template match="/record">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <!-- defines the layout master -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="first"
                                       page-height="39.7cm"
                                       page-width="21cm"
                                       margin-top="1cm"
                                       margin-bottom="2cm"
                                       margin-left="2.5cm"
                                       margin-right="2.5cm">
                    <fo:region-body/>
                    <fo:region-before extent="3cm"/>
                    <fo:region-after extent="1.5cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <!-- starts actual layout -->
            <fo:page-sequence master-reference="first">

                <fo:flow flow-name="xsl-region-body" font-family="Arial">

                    <fo:table>
                        <fo:table-column/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell display-align="center" text-align="end">
                                    <fo:block font-size="9pt" font-family="Arial">
                                        <fo:external-graphic src="url('test.png')"/>
                                    </fo:block>

                                </fo:table-cell>

                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>

                    <fo:block margin="5mm" font-family="Arial Bold" text-align="center">
                        Başvuru Formu
                    </fo:block>

                    <!-- table start -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="separate" border="1 px solid gray"
                              margin-bottom="3px" padding="3px" border-spacing="3pt">
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="5mm"/>
                        <fo:table-column column-width="100mm"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell number-columns-spanned="3">
                                    <fo:block text-align="center" font-family="Arial Bold">Başvurulan Pozisyon
                                        Bilgileri
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Başvurulan Pozisyonlar</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <fo:table table-layout="" width="100mm" border-collapse="separate">
                                            <fo:table-column/>
                                            <fo:table-column/>
                                            <fo:table-column/>
                                            <fo:table-body>
                                                <fo:table-row>
                                                    <fo:table-cell>
                                                        <fo:block>
                                                            <xsl:if test="count(jobList/job[@col='1']) > 0">
                                                                <fo:table>
                                                                    <fo:table-column/>

                                                                    <fo:table-body>
                                                                        <xsl:for-each select="jobList/job[@col='1']">
                                                                            <fo:table-row>
                                                                                <fo:table-cell>
                                                                                    <fo:block>
                                                                                        <xsl:value-of select="text()"/>
                                                                                    </fo:block>
                                                                                </fo:table-cell>
                                                                            </fo:table-row>
                                                                        </xsl:for-each>
                                                                    </fo:table-body>
                                                                </fo:table>
                                                            </xsl:if>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block>
                                                            <xsl:if test="count(jobList/job[@col='2']) > 0">
                                                                <fo:table>
                                                                    <fo:table-column/>
                                                                    <fo:table-body>
                                                                        <xsl:for-each select="jobList/job[@col='2']">
                                                                            <fo:table-row>
                                                                                <fo:table-cell>
                                                                                    <fo:block>
                                                                                        <xsl:value-of select="text()"/>
                                                                                    </fo:block>
                                                                                </fo:table-cell>
                                                                            </fo:table-row>
                                                                        </xsl:for-each>
                                                                    </fo:table-body>
                                                                </fo:table>
                                                            </xsl:if>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block>
                                                            <xsl:if test="count(jobList/job[@col='3']) > 0">
                                                                <fo:table>
                                                                    <fo:table-column/>
                                                                    <fo:table-body>
                                                                        <xsl:for-each select="jobList/job[@col='3']">
                                                                            <fo:table-row>
                                                                                <fo:table-cell>
                                                                                    <fo:block>
                                                                                        <xsl:value-of select="text()"/>
                                                                                    </fo:block>
                                                                                </fo:table-cell>
                                                                            </fo:table-row>
                                                                        </xsl:for-each>
                                                                    </fo:table-body>
                                                                </fo:table>
                                                            </xsl:if>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                            </fo:table-body>
                                        </fo:table>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Departman</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="department"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Ofis</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="office"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                        </fo:table-body>
                    </fo:table>
                    <!-- table end -->
                    <!-- table start -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="separate" border="1 px solid gray"
                              margin-bottom="3px" padding="3px" border-spacing="3pt">
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="5mm"/>
                        <fo:table-column column-width="100mm"/>

                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell number-columns-spanned="3">
                                    <fo:block text-align="center" font-family="Arial Bold">Başvuranın Bilgileri
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Adı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="name"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Soyadı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="surname"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Baba adı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="fatherName"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Telefon</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="phone"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Ünvanı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="title"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Doğum Tarihi</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="birthYear"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Doğum yeri</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="birthPlace"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                        </fo:table-body>
                    </fo:table>
                    <!-- table end -->

                    <!-- table start -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="separate" border="1 px solid gray"
                              margin-bottom="3px" padding="3px" border-spacing="3pt">
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="5mm"/>
                        <fo:table-column column-width="100mm"/>

                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell number-columns-spanned="3">
                                    <fo:block text-align="center" font-family="Arial Bold">Başvuranın Geçmişi</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Çalıştığı Yerler</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="workplaces"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Yetenekler</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="repName"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                        </fo:table-body>
                    </fo:table>
                    <!-- table end -->

                    <!-- table start -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="separate" border="1 px solid gray"
                              margin-bottom="3px" padding="3px" border-spacing="3pt">
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="5mm"/>
                        <fo:table-column column-width="100mm"/>

                        <fo:table-body>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">Önerilen İşe Başlama Zamanı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="expectedStartDate"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-family="Arial Bold">İşe Başlama Zamanı</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="startDate"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell number-columns-spanned="3">
                                    <fo:block>
                                        Hello Worl
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block></fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block></fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>

                                        <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                                            <fo:table-column column-width="30mm"/>
                                            <fo:table-column column-width="5mm"/>
                                            <fo:table-column/>
                                            <fo:table-body>
                                                <fo:table-row>
                                                    <fo:table-cell>
                                                        <fo:block>İmza</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block>:</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block></fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                                <fo:table-row>
                                                    <fo:table-cell>
                                                        <fo:block>Adı, Soyadı</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block>:</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block></fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                                <fo:table-row>
                                                    <fo:table-cell>
                                                        <fo:block>Tarih</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block>:</fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell>
                                                        <fo:block></fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                            </fo:table-body>
                                        </fo:table>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <!-- table end -->
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>
