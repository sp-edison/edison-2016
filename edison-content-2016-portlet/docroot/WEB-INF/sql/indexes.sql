create index IX_315F4C3F on EDMED_AdvancedContent (groupId);
create index IX_87E8CCBE on EDMED_AdvancedContent (groupId, serviceLanguage);

create index IX_C6A86403 on EDMED_GeneralContent (contentSeq);
create index IX_D2701361 on EDMED_GeneralContent (groupId);
create index IX_716C1FAD on EDMED_GeneralContent (groupId, contentDiv);

create index IX_F76E19C on EDMED_OrgImgContent (groupId);